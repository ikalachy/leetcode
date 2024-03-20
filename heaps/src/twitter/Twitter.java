package twitter;

import java.util.*;

public class Twitter {
    private static final int LIMIT = 10;
    User[] usersDB;
    List<Tweet> feed;

    static public class User {
        private int id;
        private Set<Integer> following;

        public User(int id) {
            this.id = id;
            following = new HashSet<>();
        }

        public void follow(int followeeId) {
            this.following.add(followeeId);
        }

        public void unfollow(int followeeId) {
            this.following.remove(followeeId);
        }

    }

    static class Tweet {
        private int id;
        private int authorId;

        public int id() {
            return id;
        }

        public int authorId() {
            return authorId;
        }

        public Tweet(int id, int authorId) {
            this.id = id;
            this.authorId = authorId;
        }
    }


    public Twitter() {
        feed = new LinkedList<>();
        usersDB = new User[500];
    }

    public void postTweet(int userId, int tweetId) {
        User user = currentUser(userId);
        feed.add(new Tweet(tweetId, user.id));
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = currentUser(userId);
        List<Integer> result = new ArrayList<>(LIMIT);

        if (feed.size() == 0) return result;

        int feedIndex = feed.size() - 1;
        while (feedIndex >= 0 && feedIndex < feed.size() && result.size() < LIMIT) {
            Tweet tweet = feed.get(feedIndex);
            if (tweet.authorId == userId || user.following.contains(tweet.authorId())) {
                result.add(tweet.id);
            }
            feedIndex -= 1;

        }
        return result;
    }

    private User currentUser(int userId) {
        User user = usersDB[userId];
        if (user == null) {
            user = new User(userId);
            usersDB[userId] = user;
        }
        return user;
    }

    public void follow(int followerId, int followeeId) {
        currentUser(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        currentUser(followerId).unfollow(followeeId);
    }
}


