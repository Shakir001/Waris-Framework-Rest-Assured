package toStoreDataInCookies;

import java.util.HashMap;

import org.testng.annotations.Test;

public class SetUsernameAndPassword {
	
	@Test
	public void demo() {
		

		int [] s = {10,5,9,6,6,9,14,1};
		HashMap map = new HashMap<>();
		for(int i=0;i<s.length;i++) {
			int count=0;
			for(int j=i+1;j<s.length;j++) {
				if(s[i]+s[j]==15) {
					count++;
					if(map.containsKey(s[i])==false && map.containsValue(s[j])==false) {
						map.put(s[i],s[j]);
					}
				}
			}
		}
		System.out.println(map);
		
		
	}
}
		
	
	
