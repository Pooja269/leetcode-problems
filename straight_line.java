/*You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2){
            return true;
        }
        int c1,c2;
        c1=coordinates[1][1]-coordinates[0][1];
        c2=coordinates[1][0]-coordinates[0][0];
        int const1=c1*coordinates[0][0];
        int const2=c2*coordinates[0][1];
        for(int i=2;i<coordinates.length;i++){
            int cross=((c1*coordinates[i][0])-const1)-((c2*(coordinates[i][1])-const2));
            if(cross!=0){
                return false;
            }
        }
        return true;
    }
}
