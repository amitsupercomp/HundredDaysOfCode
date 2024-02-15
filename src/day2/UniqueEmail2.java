package day2;
import java.util.*;

public class UniqueEmail2 {

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
		
		System.out.println("Total Unique Email count is :: " + emailsUnique(emails));		
	}
	
	private static int emailsUnique (String[] emails) {
		Set<String> uniqueEmail = new HashSet<>();
		for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replace(".", "");
            uniqueEmail.add(local + "@" + parts[1]);
        }
		return uniqueEmail.size();
	}
}
