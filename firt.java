public class a{
	public static void main(String[] args){
		int[][] arr=new int[5][5];
		int x=1;
		for(int index=0;index<arr.length;index++){
			for(int j=0;j<arr[index].length;j++){
				arr[index][j]=x;
				x++;
				System.out.print(arr[index][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int index=0;index<arr.length;index++){
			for(int j=0;j<arr[index].length;j++){
				if(j>index)
					arr[index][j]=0;
				System.out.print(arr[index][j]+"\t");

			}
			System.out.println();
		}
	}	
}