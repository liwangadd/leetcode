package leetcode.T300_T400;

import java.util.*;

public class T355 {

    private static class Post implements Comparable<Post> {
        int tweedId;
        int time;

        public Post(int tweedId, int time) {
            this.tweedId = tweedId;
            this.time = time;
        }

        @Override
        public int compareTo(Post o) {
            return o.time - time;
        }
    }

    private Map<Integer, List<Integer>> users;
    Map<Integer, Queue<Post>> postMap;
    private int totalTime = 0;

    /**
     * Initialize your data structure here.
     */
    public T355() {
        users = new HashMap<>();
        postMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (postMap.containsKey(userId)) {
            postMap.get(userId).add(new Post(tweetId, totalTime++));
        } else {
            Queue<Post> posts = new PriorityQueue<>();
            posts.add(new Post(tweetId, totalTime++));
            postMap.put(userId, posts);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> queue = new PriorityQueue<>();
        if (postMap.containsKey(userId)) {
            queue.addAll(postMap.get(userId));
        }
        List<Integer> followees = users.get(userId);
        if (followees != null && !followees.isEmpty()) {
            for (Integer followee : followees) {
                if (postMap.containsKey(followee)) {
                    queue.addAll(postMap.get(followee));
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        for (int i = 0; i < 10 && !queue.isEmpty(); ++i) {
            Post post = queue.poll();
            if (post != null)
                res.add(post.tweedId);
            else break;
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        if (users.containsKey(followerId)) {
            if (!users.get(followerId).contains(followeeId))
                users.get(followerId).add(followeeId);
        } else {
            List<Integer> followees = new LinkedList<>();
            followees.add(followeeId);
            users.put(followerId, followees);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            List<Integer> followees = users.get(followerId);
            followees.remove((Integer) followeeId);
        }
    }

    public static void main(String[] args) {
        T355 twitter = new T355();

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
    }

}
