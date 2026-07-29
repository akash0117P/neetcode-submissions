class Twitter {
    int count;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>());
        tweetMap.get(userId).add(new int[] {count--, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        List<Integer> res = new ArrayList<>();

        // User should always follow themselves
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        // Add the latest tweet from each followee
        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId))
                continue;

            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);

            minHeap.offer(new int[] {
                tweet[0], // timestamp
                tweet[1], // tweetId
                followeeId, // owner
                index // current index
            });
        }

        // Extract the 10 most recent tweets
        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();

            res.add(curr[1]);

            int followeeId = curr[2];
            int index = curr[3];

            // Push the next older tweet from the same user
            if (index > 0) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int[] nextTweet = tweets.get(index - 1);

                minHeap.offer(new int[] {nextTweet[0], nextTweet[1], followeeId, index - 1});
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
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
