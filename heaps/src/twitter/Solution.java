package twitter;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {


//        Your Twitter object will be instantiated and called as such:
        Twitter obj = new Twitter();
        int userId = 1;
        int tweetId = 5;
        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        obj.postTweet(1, 6);
        List<Integer> param_2 = obj.getNewsFeed(userId);
        System.out.println(Arrays.toString(new List[]{param_2}));

//        obj.follow(1, 2);
//        List<Integer> param_3 = obj.getNewsFeed(userId);
//
//        obj.unfollow(1, 2);
//        List<Integer> param_4 = obj.getNewsFeed(userId);


    }
}
