package exercise;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn=new PalindromeNumber();
		System.out.print(pn.checkPalin(1213121));
	}
	public boolean checkPalin(int num){
		return (reverse(num)==num)?true:false;
}
public int reverse(int num){
	int res=0;
	while(num>0){
		res=res*10+num%10;
		num=num/10;
}
return res;
}

}
