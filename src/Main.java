import java.util.*;

public class Main {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] bfs = sc.nextLine().split(" ");
            String[] in = sc.nextLine().split(" ");
            System.out.println();

            System.out.println();
        }

    }


    public static String preOder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        StringBuffer sb = new StringBuffer();
        while(!stack.empty() || cur != null){
            if(cur != null){
                sb.append(cur.val+" ");
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                cur = node.right;
            }
        }
        return sb.toString();
    }
    public static String inOder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            if(cur != null){//先打印最左下角的
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                if(node.left == null && node.right == null){
                    sb.append(node.val + " ");
                }
            }
            cur = node.right;
        }
        return sb.toString();
    }




    public static Stack<Integer>  afterOder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            if(cur != null){
                resStack.push(cur.val);// Reverse the process of preorder
                stack.push(cur);
                cur = cur.right;// Reverse the process of preorder
            }else{
                TreeNode node = stack.pop();
                cur = node.left;// Reverse the process of preorder
            }
        }
        return resStack;
    }

    private  static TreeNode buildTreeByMidLevel(int[] mid, int[] level, int midBegin, int midEnd) {
        TreeNode root = new TreeNode(level[0]);
        int midLoc = -1;
        for (int i = midBegin; i <= midEnd; i++) {
            if (mid[i] == level[0]) {
                midLoc = i;
                break;
            }
        }
        if (level.length >= 2) {
            if (isLeft(mid, level[0], level[1])) {
                TreeNode left = buildTreeByMidLevel(mid, getLevelStr(mid, midBegin, midLoc - 1, level), midBegin, midLoc - 1);
                root.leftChild = left;
                if (level.length >= 3 && !isLeft(mid, level[0], level[2])) {
                    TreeNode right = buildTreeByMidLevel(mid, getLevelStr(mid, midLoc + 1, midEnd, level), midLoc + 1, midEnd);
                    root.rightChild = right;
                }
            }
            else { TreeNode right = buildTreeByMidLevel(mid, getLevelStr(mid, midLoc + 1, midEnd, level), midLoc + 1, midEnd);
                root.rightChild = right;
            }
        } return root;
    } /** * 将中序序列中midBegin与MidEnd的字符依次从level中提取出来，保持level中的字符顺序不变 */
private static  char[] getLevelStr(int[] mid, int midBegin, int midEnd, char[] level) {
    char[] result = new char[midEnd - midBegin + 1];
    int curLoc = 0;
    for (int i = 0; i < level.length; i++) {
        if (contains(mid, level[i], midBegin, midEnd)) {
            result[curLoc++] = level[i];
        }
    }
    return result;
} /** * 如果str字符串的begin和end位置之间（包括begin和end）含有字符target,则返回true。 */
private  static boolean contains(int[] str, char target, int begin, int end) {
    for (int i = begin; i <= end; i++) {
        if (str[i] == target) {
            return true;
        }
    }
    return false;
}


class TreeNode {
    private int name;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int name) {
        this.name = name;
    }

    public void setName(int name) {
        this.name = name;
    }
}

    private  static  boolean isLeft(int[] str, int target, char c) {
        boolean findC = false;
        for (int temp : str) {
            if (temp == c) {
                findC = true;
            } else if (temp == target) {
                return findC;
            }
        }
        return false;
    }

}