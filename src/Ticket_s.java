package C_java;

import java.util.ArrayList;
import java.util.Scanner;

import C_java.Ticket_s;

public class Ticket_s {

	Scanner scanner = new Scanner(System.in);
	static Orderdata orderItem = null;
	ArrayList<Orderdata> orderList = new ArrayList<Orderdata>();


	void selectTicket() {// 권종 선택

		orderItem = new Orderdata();
		do {
			System.out.printf("선택해주세요.\n1. 종합이용권(롯데월드+민속박물관)  \n2. 파크이용권\n");
			orderItem.choose = scanner.nextInt();
		} while (!(orderItem.choose == 1 || orderItem.choose == 2));

		do {
			System.out.printf("권종을 선택하세요.\n1. 1DAY \n2. AFTER4(오후 4시 이후 입장)\n");
			orderItem.ticket = scanner.nextInt();
		} while (!(orderItem.ticket == 1 || orderItem.ticket == 2));
	}

	void personNumber() {// 주민번호 앞자리 6글자 +뒷자리 1글자

		do {
			System.out.printf("주민번호 앞자리 6자글자를 입력하세요 ex)990909\n");
			orderItem.FrontNumber = scanner.nextInt();
			
			System.out.println("\n주민번호 뒷자리 1자리를 입력하세요 ex) 1 or 2 or 3 or 4\n");
			orderItem.BackNumber = scanner.nextInt();
			

		} while (!(orderItem.FrontNumber > 010001 && orderItem.FrontNumber < 999999 && (orderItem.BackNumber == 1
				|| orderItem.BackNumber == 2 || orderItem.BackNumber == 3 || orderItem.BackNumber == 4)));

	}

	void countTicket() { // 주문갯수

		do {
			System.out.printf("몇개를 주문하시겠습니가?(최대 10개)\n");
			orderItem.orderCount = scanner.nextInt();
		} while (!(orderItem.orderCount >= 1 && orderItem.orderCount < 11));
	}

	void discountMoney() { // 우대사항

		do {
			System.out.printf("우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인\n3. 국가유공자\n4. 다둥이 행복\n5. 임산부\n6. 휴가장병 \n");
			orderItem.discount = scanner.nextInt();
		} while (!(orderItem.discount == 1 || orderItem.discount == 2 || orderItem.discount == 3
				|| orderItem.discount == 4 || orderItem.discount == 5 || orderItem.discount == 6));
	}

	void monthAge() { // 만나이 계산

		orderItem.numberYear = orderItem.FrontNumber / 10000; // 생년 출력
		orderItem.birth = orderItem.FrontNumber - (orderItem.numberYear * 10000); // 생일 출력

		if (orderItem.BackNumber == 1 || orderItem.BackNumber == 2) { // 1900년생 || 2000년생 출력
			orderItem.oldage = orderItem.numberYear + 1900;
		} else if (orderItem.BackNumber == 3 || orderItem.BackNumber == 4) { // 해결안됨
			orderItem.newage = orderItem.numberYear + 2000;
		}

		if (orderItem.birth > 414 && orderItem.oldage < 2000) { // 만나이
			orderItem.age = 2022 - orderItem.oldage - 1;
		} else if (orderItem.birth <= 414 && orderItem.oldage < 2000) {
			orderItem.age = 2022 - orderItem.oldage;
		}

		if (orderItem.birth > 414 && orderItem.newage >= 2000) {
			orderItem.age = 2022 - orderItem.newage - 1;
		} else if (orderItem.birth <= 414 && orderItem.newage >= 2000) {
			orderItem.age = 2022 - orderItem.newage;
		}
	}

	void chooseAgePrice() { // 티켓별 나이대 별 가격

		switch (orderItem.choose) {
		case 1:
			switch (orderItem.ticket) {
			case 1:

				if (orderItem.age <= 3) {
					orderItem.prise = StaticValue.BABY_PRICE;
				} else if (orderItem.age > 3 && orderItem.age <= 12) {
					orderItem.prise = StaticValue.ALL_DAY_CHILD_PRICE;
				} else if (orderItem.age > 12 && orderItem.age <= 18) {
					orderItem.prise = StaticValue.ALL_DAY_TEEN_PRICE;
				} else if (orderItem.age >= 19 && orderItem.age <= 64) {
					orderItem.prise = StaticValue.ALL_DAY_ADULT_PRICE;
				} else if (orderItem.age >= 65) {
					orderItem.prise = StaticValue.ALL_DAY_CHILD_PRICE;
				}
				break;

			case 2:
				if (orderItem.age <= 3) {
					orderItem.prise = StaticValue.BABY_PRICE;
				} else if (orderItem.age > 3 && orderItem.age <= 12) {
					orderItem.prise = StaticValue.ALL_AFTER_CHILD_PRICE;
				} else if (orderItem.age > 12 && orderItem.age <= 18) {
					orderItem.prise = StaticValue.ALL_AFTER_TEEN_PRICE;
				} else if (orderItem.age >= 19 && orderItem.age <= 64) {
					orderItem.prise = StaticValue.ALL_AFTER_ADULT_PRICE;
				} else if (orderItem.age >= 65) {
					orderItem.prise = StaticValue.ALL_AFTER_CHILD_PRICE;
				}
				break;
			}
			break;
		case 2:
			switch (orderItem.ticket) {
			case 1:
				if (orderItem.age <= 3) {
					orderItem.prise = StaticValue.BABY_PRICE;
				} else if (orderItem.age > 3 && orderItem.age <= 12) {
					orderItem.prise = StaticValue.PARK_DAY_CHILD_PRICE;
				} else if (orderItem.age > 12 && orderItem.age <= 18) {
					orderItem.prise = StaticValue.PARK_DAY_TEEN_PRICE;
				} else if (orderItem.age >= 19 && orderItem.age <= 64) {
					orderItem.prise = StaticValue.PARK_DAY_ADULT_PRICE;
				} else if (orderItem.age >= 65) {
					orderItem.prise = StaticValue.PARK_DAY_CHILD_PRICE;
				}
				break;
			case 2:
				if (orderItem.age <= 3) {
					orderItem.prise = StaticValue.BABY_PRICE;
				} else if (orderItem.age > 3 && orderItem.age <= 12) {
					orderItem.prise = StaticValue.PARK_AFTER_CHILD_PRICE;
				} else if (orderItem.age > 12 && orderItem.age <= 18) {
					orderItem.prise = StaticValue.PARK_AFTER_TEEN_PRICE;
				} else if (orderItem.age >= 19 && orderItem.age <= 64) {
					orderItem.prise = StaticValue.PARK_AFTER_ADULT_PRICE;
				} else if (orderItem.age >= 65) {
					orderItem.prise = StaticValue.PARK_AFTER_CHILD_PRICE;
				}
				break;
			}
			break;
		default:
			System.out.printf("잘못 입력하셨습니다. ");
		}
	}

	void discountCase() {// 우대사항 별 할인

		switch (orderItem.discount) {
		case 1:
			orderItem.final2 = orderItem.prise;
			break;
		case 2:
			orderItem.final2 = (int) (orderItem.prise * 0.5);
			break;
		case 3:
			orderItem.final2 = (int) (orderItem.prise * 0.5);
			break;
		case 4:
			if (orderItem.choose == 1) {
				orderItem.final2 = (int) (orderItem.prise - (orderItem.prise * 0.3)); // 종합만 할 인
			} else if (orderItem.choose == 2) {
				orderItem.final2 = orderItem.prise;

			} // 파크는 할인적용 제외
			break;
		case 5:
			if (orderItem.choose == 1) {
				orderItem.final2 = (int) (orderItem.prise * 0.5); // 종합만 할 인
			} else if (orderItem.choose == 2) {
				orderItem.final2 = orderItem.prise;
			} // 파크는 할인적용 제외
			break;
		case 6:
			if (orderItem.choose == 1) {
				orderItem.final2 = (int) ((orderItem.prise * 0.50) + 500); // 종합만 할 인
			} else if (orderItem.choose == 2) {
				orderItem.final2 = orderItem.prise;
			} // 파크는 할인적용 제외
			break;
		}
	}

	void ageSelectCase() { // 나이, 권종별 케이스 정리

		// 나이 케이스 정립
		if (orderItem.age < StaticValue.KID_BABY_AGE && orderItem.age >= StaticValue.BABY_AGE_MIN) {
			orderItem.ageCase = 4; // 베이비
		} else if ((orderItem.age >= StaticValue.KID_BABY_AGE && orderItem.age < StaticValue.TEEN_KID_AGE)) {
			orderItem.ageCase = 3; // 어린이
		} else if (orderItem.age >= StaticValue.TEEN_KID_AGE && orderItem.age <= StaticValue.TEEN_AGE_MAX) {
			orderItem.ageCase = 2; // 청소년
		} else if (orderItem.age >= StaticValue.OLDMAN_AGE) {
			orderItem.ageCase = 5; // 노 인
		} else {
			orderItem.ageCase = 1; // 어른
		}

		// 종합/파크&& 주간야간 선택
		if (orderItem.choose == 1 && orderItem.ticket == 1) {
			orderItem.ticketTimeCase = 1; // 종합 + 1Day
		} else if (orderItem.choose == 1 && orderItem.ticket == 2) {
			orderItem.ticketTimeCase = 2; // 종합 + 4시이후
			orderItem.ticketTimeCase = 3; // 파크 + 1Day
		} else {
			orderItem.ticketTimeCase = 4; // 파크 + 4시후
		}

	}

	void function_selectOption() {
		selectTicket();
		personNumber();
		monthAge();
		countTicket();
		discountMoney();
	}

	void function_calculateData() {
		ageSelectCase();
		chooseAgePrice();
		discountCase();
	}

	private void inputDatainArray() {
		orderList.add(orderItem);
	}

	void PrintIt() {

		orderItem.sum = orderItem.final2 * orderItem.orderCount;
		orderItem.next = scanner.nextInt();

		System.out.printf(" *****************************\n");
		System.out.printf(" 가격은 %d원 입니다.\n 감사합니다.\n", orderItem.sum);
		System.out.printf(" *****************************\n");
		System.out.printf("계속 발권 하시겠습니까?\n 1. 티켓 발권 \n 2. 종료\n");
		do {
			function_selectOption();
			inputDatainArray();
			function_calculateData();
			PrintIt();
			
		} while (orderItem.next == 1); {
			
		} if (orderItem.next == 2) {
			System.out.printf("\n이용해주셔서 감사합니다.\n");
		}
	}
	
	void PrintIt2() {
		
		// 영수증 출력
		System.out.printf("\n\n===================================== 롯데월드  =====================================\n");
		System.out.printf("%s\t\t%s\t     %s\t  %s\t\t%s\n", "선택사항", "연  령", "매수", "가격", "우대사항");

		for (int i = 0; i < orderList.size(); i++) {
	
			switch (orderItem.choose) {
			case 1:
				System.out.printf("%s\t%s", "종합이용권", "1Day");
				break;
			case 2:
				System.out.printf("%s\t%s", "종합이용권", "After4");
				break;
			case 3:
				System.out.printf("%s\t%s", "파크이용권", "1Day");
				break;
			case 4:
				System.out.printf("%s\t%s", "파크이용권", "After4");
				break;
			default:
				break;
			}
	
			switch (orderItem.ageCase) {
			case 1:
				System.out.printf("\t%s", "어  른");
				break;
			case 2:
				System.out.printf("\t%s", "청소년");
				break;
			case 3:
				System.out.printf("\t%s", "어린이");
				break;
			case 4:
				System.out.printf("\t%s", "유  아");
				break;
			case 5:
				System.out.printf("\t%s", "노  인");
				break;
			case 6:
				System.out.printf("\t%s", "영  아");
				break;
			default:
				break;
			}
	
			System.out.printf("%10d%14d원\t", orderItem.orderCount, orderItem.final2);
	
			switch (orderItem.discount) {
			case 1:
				System.out.printf("%s\n", "우대사항 없음");
				break;
			case 2:
				System.out.printf("%s\n", "장애인 우대");
				break;
			case 3:
				System.out.printf("%s\n", "국가유공자 우대");
				break;
			case 4:
				System.out.printf("%s\n", "다둥이 행복 우대");
				break;
			case 5:
				System.out.printf("%s\n", "임산부 우대");
				break;
			case 6:
				System.out.printf("%s\n", "휴가장병 우대");
				break;
			default:
				break;
			}
		
	
			System.out.printf("\n입장료 총액은 %d원 입니다.", orderItem.sum);
			System.out.printf("\n=====================================================================================\n");
			System.out.printf("\n계속 진행하시겠습니까? (1:새로운 주문, 2:프로그램 종료) : ");

			int again = scanner.nextInt();
			if (again == 1) {
				function_selectOption();
				inputDatainArray();
				function_calculateData();
	
				continue;
			} else if (again == 2) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {

		Ticket_s ticket = new Ticket_s();
		
		ticket.function_selectOption();
		ticket.inputDatainArray();
		ticket.function_calculateData();
		ticket.PrintIt();
		ticket.PrintIt2();

		
	}

}
