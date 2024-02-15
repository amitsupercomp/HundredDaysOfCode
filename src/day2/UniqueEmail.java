package day2;
import java.util.*;

public class UniqueEmail {

	public static void main(String[] args) {
			
			String[] emails = {"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com",
			                    "fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com",
			                    "fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com",
			                    "fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com",
			                    "r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com",
			                    "r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com",
			                    "r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com",
			                    "fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com",
			                    "fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"}; 
			System.out.println("Total emails ::: " + emails(emails));
		}
		
	private static int emails (String[] emails) {
		Set<String> uniqueSet = new HashSet<>();		
		for (int i = 0; i < emails.length; i++) {
			String first = emails[i].substring(0, emails[i].indexOf('@'));
			String second = emails[i].substring(emails[i].indexOf('@') + 1);
			if (second.indexOf('@') != -1)
				continue;
			String local = "";
			int limit = 0;
			while (limit < emails[i].indexOf('@')) {
				if (first.charAt(limit) == '+')
					break;
				else if (first.charAt(limit) == '.') {
					limit++;
					continue;
				}
				else {
					local += first.charAt(limit);
					limit++;
				}
			}
			String finalEmail = local + "@" + second;
			uniqueSet.add(finalEmail);
		}
		return uniqueSet.size();
	}
}
