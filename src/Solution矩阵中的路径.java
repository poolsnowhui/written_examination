import java.util.Stack;

public class Solution矩阵中的路径 {
	public static void main(String[] args) {
		/**
		 * "ABCESFCSADEE",3,4,"SEE"
		 * "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SLHECCEIDEJFGGFIE"
		 * "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEM"
		 */
		String m = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
		char[] ma = m.toCharArray();
		String s = "SGGFIECVAASABCEHJIGQEM";
		System.out.println(new Solution矩阵中的路径().hasPath(ma, 5, 8, s.toCharArray()));
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean traveled[][] = new boolean[rows][cols];
		Stack<Position> posStack = new Stack<>();// 位置栈上左下右;
		char[][] m = new char[rows][cols];
		int k = 0, r = 0, c = 0;
		boolean flag = false;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

				m[i][j] = matrix[k++];
			}
		}
		for ( r=0; r < m.length; r++) {
			for (c=0 ;c  < m[r].length; c++) {
				if(m[r][c]==str[0]) {
					flag =true;
					break;
				}
			}
			if(flag) break;
		}
		if(!flag) return false;
		
		boolean ft = true, fl = true, fd = true, fr = true;
		boolean ftcg =false;//未弹出过
		System.out.println("r="+r+",c="+c);
		for (int i = 1; i < str.length; i++) {
			traveled[r][c] = true;
			if(!ftcg){//未弹出过
				ft=true;
				fl=true;
				fd=true;
				fr=true;
			}
			if (ft && r - 1 >= 0 && !traveled[r - 1][c] && m[r - 1][c] == str[i]) {// top
				r = r - 1;
				System.out.println("r="+r+",c="+c);
				posStack.push(Position.TOP);
				ftcg =false;//未弹出过
			} else if (fl && c - 1 >= 0 && !traveled[r][c - 1] && m[r][c - 1] == str[i]) {// left
				c = c - 1;
				System.out.println("r="+r+",c="+c);
				posStack.push(Position.LEFT);
				ftcg =false;//未弹出过
			} else if (fd && r + 1 < rows && !traveled[r + 1][c] && m[r + 1][c] == str[i]) {// down
				r++;
				System.out.println("r="+r+",c="+c);
				posStack.push(Position.DOWN);
				ftcg =false;//未弹出过
			} else if (fr && c + 1 < cols && !traveled[r][c + 1] && m[r][c + 1] == str[i]) {// right
				c++;
				System.out.println("r="+r+",c="+c);
				posStack.push(Position.RIGHT);
				ftcg =false;//未弹出过
			} else {
				if (posStack.isEmpty()) {
					traveled[r][c] = false;
					flag = false;
					if(c+1<cols) c++;
					else if(r+1<rows) {
						r++;c=0;
					}else{
						return false;
					}
					for ( ; r < m.length; r++) {
						for ( ;c  < m[r].length; c++) {
							if(m[r][c]==str[0]) {
								flag =true;
								System.out.println("第一个r="+r+",c="+c);
								break;
							}
						}
						if(flag) break;
						else c=0;
					}
					i=0;
					if(!flag) return false;
				} else {
					traveled[r][c] = false;
					System.out.println(posStack.peek());
					System.out.println("弹出r="+r+",c="+c);
					switch (posStack.peek()) {
					case TOP:
						r++;
						posStack.pop();
						ft = false;
						fl = true;
						fd = true;
						fr = true;
						break;
					case LEFT:
						c++;
						posStack.pop();
						ft = false;
						fl = false;
						fd = true;
						fr = true;
						break;
					case DOWN:
						r--;
						posStack.pop();
						ft = false;
						fl = false;
						fd = false;
						fr = true;
						break;
					case RIGHT:
						c--;
						posStack.pop();
						ft = false;
						fl = false;
						fd = false;
						fr = false;

						break;
					default:
						break;
					}
					ftcg = true;
					i=i-2;
				}
			}
		}


		return true;
	}


	public enum Position {
		TOP, LEFT, DOWN, RIGHT;
	}
}
