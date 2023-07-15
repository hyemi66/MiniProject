package main;

import java.util.Scanner;

import member.MemberService;
import movie.MovieService;
import ticket.TicketService;

public class MainMovie {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		MemberService ms = new MemberService();
		MovieService mos = new MovieService();
		
		
		while(true) {
			System.out.println("*^*^* M O V I E *^*^*");
			System.out.println("1. 로그인 및 회원가입");
			System.out.println("2. 영화 예매");
			System.out.println("3. 종료");
			System.out.print(">>> ");
			num = sc.nextInt();
			switch(num) {
			case 1 : 
				ms.memberMain();
				break;
			case 2 : 
				mos.movieMain();
				break;
			case 3 : 
				System.out.println("안녕히가세요");
				System.exit(1);
			}
		}
	}
}
