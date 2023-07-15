package ticket;

import java.util.ArrayList;
import java.util.Scanner;

import movie.MovieDB;
import movie.MovieDTO;

public class TicketService {
	public void ticketMain() {
		TicketDTO dto = new TicketDTO();
		TicketDB db = new TicketDB();
		Scanner sc = new Scanner(System.in);
		int num;
		String tic_id;
		ArrayList<TicketDTO> list;
		
		while(true) {
			System.out.println("* 영화 예매확인 및 예매취소 *");
			System.out.println("1. 예매확인");
			System.out.println("2. 예매취소");
			System.out.println("3. 나가기");
			System.out.print(">>> ");
			num = sc.nextInt();
			switch(num) {
			case 1 : 
				System.out.print("아이디 입력 : ");
				tic_id = sc.next();
				list = db.check(tic_id);
				if(list.size() == 0) {
					System.out.println("내역이 없습니다");
					break;
				}
				System.out.println("-- 예매내역 --");
				for(TicketDTO t : list) {
					System.out.println("영화제목 : " + t.getTic_name());
					System.out.println("영화시간 : " + t.getTic_time());
					System.out.println("영화장소/지역 : " + t.getTic_place() + "/" + t.getTic_area());
				}
				break;
			case 2 : 
				System.out.print("아이디 입력 : ");
				tic_id = sc.next();
				list = db.check(tic_id);
				if(list.size()==0) {
					System.out.println("내역이 없습니다");
					break;
				}
				System.out.println("-- 예매 내역 확인 --");
				for(TicketDTO t : list) {
					System.out.println("영화제목 : " + t.getTic_name());
					System.out.println("영화시간 : " + t.getTic_time());
					System.out.println("영화장소/지역 : " + t.getTic_place() + "/" + t.getTic_area());
				}
				System.out.println("----------");
				System.out.println("취소하시겠습니까?");
				System.out.println("1. 네 2. 아니오");
				System.out.print(">>> ");
				num = sc.nextInt();
				if(num == 1) {
					db.delete(tic_id);
					list = db.check(tic_id);
					MovieDTO mdto = new MovieDTO();
					for(TicketDTO t : list) {
						mdto.setMov_name(t.getTic_name());
						mdto.setMov_place(t.getTic_place());
					}
					MovieDB mdb = new MovieDB();
					ArrayList<MovieDTO> mlist = new ArrayList<>();
					mlist = mdb.pickM(mdto.getMov_name(), mdto.getMov_place());
					for(MovieDTO m : mlist) {
						mdto.setMov_name(m.getMov_name());
						mdto.setMov_place(m.getMov_place());
						mdto.setMov_seat((m.getMov_seat())+1);						
					}
					mdb.seatCount(mdto);
					System.out.println("예매내역이 취소되었습니다");
					
				} else if(num == 2) {
					return;
				}
				break;
			case 3 :
				return;
			}
		}
	}
}
