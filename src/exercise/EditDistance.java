package exercise;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed=new EditDistance();
		boolean res=ed.check("abc", "ac");
		System.out.print(res);
	}
		public boolean check(String s, String t){
			if(Math.abs(s.length()-t.length())>1){
				return false;
			}
			int i=0,j=0;
			for(;i<s.length()&&j<t.length();i++,j++){
				if(s.charAt(i)!=t.charAt(i)){
					break;
				}
			}
			if(i==s.length()&&j==t.length()){ //exactly the same
	return false;
}
else{
return checkAt(s,t,i);
}

	}
		
	public boolean checkAt(String s, String t, int index){
		char ch='\0';
		if(index<t.length()){
			ch=t.charAt(index);
		}
		String s1=s.substring(0, index)+ch+s.substring(index+1, s.length());
		String s2=s.substring(0, index)+ch+s.substring(index, s.length());
		String s3=s.substring(0, index)+s.substring(index+1, s.length());
		if(s1.equals(t)||s2.equals(t)||s3.equals(t)){
		return true;
	}
	return false;
	}
	}


