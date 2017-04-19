import java.util.*;

// class breakData{
//     public static void main (String[] args){
//         ArrayList<MyData> users = new ArrayList<MyData>();

//             users.add(new MyData(x, y));
//     }
// }

class MyData {
    // private String userName;
    private int userID;
    private int sentValue;

    public MyData(int userID, int sentValue) {
    // this.userName = userName;
        this.userID = userID;
        this.sentValue = sentValue;
    }
    // public String getUserName() {
    //     return userName;
    // }

    public int getUserID() {
        return userID;
    }

    public int getSentValue() {
        return sentValue;
    }
}
