class Twitter {
    int count;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>());
        tweetMap.get(userId).add(new int[] {count--, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        followMap.computeIfAbsent(userId, k -> new HashSet<>());
        followMap.get(userId).add(userId);

        List<Integer> res = new ArrayList<>();

        for (int followee : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.get(followee);

            if (tweets == null || tweets.isEmpty()) {
                continue;
            }

            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);

            pq.offer(new int[] {tweet[0], tweet[1], followee, index});
        }

        while (!pq.isEmpty() && res.size() < 10) {
            int[] curTweets = pq.poll();
            res.add(curTweets[1]);

            List<int[]> temp = tweetMap.get(curTweets[2]);
            int idx = curTweets[3];

            if (idx > 0) {
                int[] curTweet = temp.get(idx - 1);
                pq.offer(new int[] {curTweet[0], curTweet[1], curTweets[2], idx - 1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.computeIfAbsent(followerId, k -> new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
