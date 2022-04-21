package C_java;

import java.util.ArrayList;
import java.util.Scanner;

import C_java.Ticket_s;

public class Ticket_s {

	Scanner scanner = new Scanner(System.in);
	static Orderdata orderItem = null;
	ArrayList<Orderdata> orderList = new ArrayList<Orderdata>();


	void selectTicket() {// ���� ����

		orderItem = new Orderdata();
		do {
			System.out.printf("�������ּ���.\n1. �����̿��(�Ե�����+�μӹڹ���)  \n2. ��ũ�̿��\n");
			orderItem.choose = scanner.nextInt();
		} while (!(orderItem.choose == 1 || orderItem.choose == 2));

		do {
			System.out.printf("������ �����ϼ���.\n1. 1DAY \n2. AFTER4(���� 4�� ���� ����)\n");
			orderItem.ticket = scanner.nextInt();
		} while (!(orderItem.ticket == 1 || orderItem.ticket == 2));
	}

	void personNumber() {// �ֹι�ȣ ���ڸ� 6���� +���ڸ� 1����

		do {
			System.out.printf("�ֹι�ȣ ���ڸ� 6�ڱ��ڸ� �Է��ϼ��� ex)990909\n");
			orderItem.FrontNumber = scanner.nextInt();
			
			System.out.println("\n�ֹι�ȣ ���ڸ� 1�ڸ��� �Է��ϼ��� ex) 1 or 2 or 3 or 4\n");
			orderItem.BackNumber = scanner.nextInt();
			

		} while (!(orderItem.FrontNumber > 010001 && orderItem.FrontNumber < 999999 && (orderItem.BackNumber == 1
				|| orderItem.BackNumber == 2 || orderItem.BackNumber == 3 || orderItem.BackNumber == 4)));

	}

	void countTicket() { // �ֹ�����

		do {
			System.out.printf("��� �ֹ��Ͻðڽ��ϰ�?(�ִ� 10��)\n");
			orderItem.orderCount = scanner.nextInt();
		} while (!(orderItem.orderCount >= 1 && orderItem.orderCount < 11));
	}

	void discountMoney() { // ������

		do {
			System.out.printf("�������� �����ϼ���.\n1. ����(���� ���� �ڵ�ó��)\n2. �����\n3. ����������\n4. �ٵ��� �ູ\n5. �ӻ��\n6. �ް��庴 \n");
			orderItem.discount = scanner.nextInt();
		} while (!(orderItem.discount == 1 || orderItem.discount == 2 || orderItem.discount == 3
				|| orderItem.discount == 4 || orderItem.discount == 5 || orderItem.discount == 6));
	}

	void monthAge() { // ������ ���

		orderItem.numberYear = orderItem.FrontNumber / 10000; // ���� ���
		orderItem.birth = orderItem.FrontNumber - (orderItem.numberYear * 10000); // ���� ���

		if (orderItem.BackNumber == 1 || orderItem.BackNumber == 2) { // 1900��� || 2000��� ���
			orderItem.oldage = orderItem.numberYear + 1900;
		} else if (orderItem.BackNumber == 3 || orderItem.BackNumber == 4) { // �ذ�ȵ�
			orderItem.newage = orderItem.numberYear + 2000;
		}

		if (orderItem.birth > 414 && orderItem.oldage < 2000) { // ������
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

	void chooseAgePrice() { // Ƽ�Ϻ� ���̴� �� ����

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
			System.out.printf("�߸� �Է��ϼ̽��ϴ�. ");
		}
	}

	void discountCase() {// ������ �� ����

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
				orderItem.final2 = (int) (orderItem.prise - (orderItem.prise * 0.3)); // ���ո� �� ��
			} else if (orderItem.choose == 2) {
				orderItem.final2 = orderItem.prise;

			} // ��ũ�� �������� ����
			break;
		case 5:
			if (orderItem.choose == 1) {
				orderItem.final2 = (int) (orderItem.prise * 0.5); // ���ո� �� ��
			} else if (orderItem.choose == 2) {
				orderItem.final2 = orderItem.prise;
			} // ��ũ�� �������� ����
			break;
		case 6:
			if (orderItem.choose == 1) {
				orderItem.final2 = (int) ((orderItem.prise * 0.50) + 500); // ���ո� �� ��
			} else if (orderItem.choose == 2) {
				orderItem.final2 = orderItem.prise;
			} // ��ũ�� �������� ����
			break;
		}
	}

	void ageSelectCase() { // ����, ������ ���̽� ����

		// ���� ���̽� ����
		if (orderItem.age < StaticValue.KID_BABY_AGE && orderItem.age >= StaticValue.BABY_AGE_MIN) {
			orderItem.ageCase = 4; // ���̺�
		} else if ((orderItem.age >= StaticValue.KID_BABY_AGE && orderItem.age < StaticValue.TEEN_KID_AGE)) {
			orderItem.ageCase = 3; // ���
		} else if (orderItem.age >= StaticValue.TEEN_KID_AGE && orderItem.age <= StaticValue.TEEN_AGE_MAX) {
			orderItem.ageCase = 2; // û�ҳ�
		} else if (orderItem.age >= StaticValue.OLDMAN_AGE) {
			orderItem.ageCase = 5; // �� ��
		} else {
			orderItem.ageCase = 1; // �
		}

		// ����/��ũ&& �ְ��߰� ����
		if (orderItem.choose == 1 && orderItem.ticket == 1) {
			orderItem.ticketTimeCase = 1; // ���� + 1Day
		} else if (orderItem.choose == 1 && orderItem.ticket == 2) {
			orderItem.ticketTimeCase = 2; // ���� + 4������
			orderItem.ticketTimeCase = 3; // ��ũ + 1Day
		} else {
			orderItem.ticketTimeCase = 4; // ��ũ + 4����
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
		System.out.printf(" ������ %d�� �Դϴ�.\n �����մϴ�.\n", orderItem.sum);
		System.out.printf(" *****************************\n");
		System.out.printf("��� �߱� �Ͻðڽ��ϱ�?\n 1. Ƽ�� �߱� \n 2. ����\n");
		do {
			function_selectOption();
			inputDatainArray();
			function_calculateData();
			PrintIt();
			
		} while (orderItem.next == 1); {
			
		} if (orderItem.next == 2) {
			System.out.printf("\n�̿����ּż� �����մϴ�.\n");
		}
	}
	
	void PrintIt2() {
		
		// ������ ���
		System.out.printf("\n\n===================================== �Ե�����  =====================================\n");
		System.out.printf("%s\t\t%s\t     %s\t  %s\t\t%s\n", "���û���", "��  ��", "�ż�", "����", "������");

		for (int i = 0; i < orderList.size(); i++) {
	
			switch (orderItem.choose) {
			case 1:
				System.out.printf("%s\t%s", "�����̿��", "1Day");
				break;
			case 2:
				System.out.printf("%s\t%s", "�����̿��", "After4");
				break;
			case 3:
				System.out.printf("%s\t%s", "��ũ�̿��", "1Day");
				break;
			case 4:
				System.out.printf("%s\t%s", "��ũ�̿��", "After4");
				break;
			default:
				break;
			}
	
			switch (orderItem.ageCase) {
			case 1:
				System.out.printf("\t%s", "��  ��");
				break;
			case 2:
				System.out.printf("\t%s", "û�ҳ�");
				break;
			case 3:
				System.out.printf("\t%s", "���");
				break;
			case 4:
				System.out.printf("\t%s", "��  ��");
				break;
			case 5:
				System.out.printf("\t%s", "��  ��");
				break;
			case 6:
				System.out.printf("\t%s", "��  ��");
				break;
			default:
				break;
			}
	
			System.out.printf("%10d%14d��\t", orderItem.orderCount, orderItem.final2);
	
			switch (orderItem.discount) {
			case 1:
				System.out.printf("%s\n", "������ ����");
				break;
			case 2:
				System.out.printf("%s\n", "����� ���");
				break;
			case 3:
				System.out.printf("%s\n", "���������� ���");
				break;
			case 4:
				System.out.printf("%s\n", "�ٵ��� �ູ ���");
				break;
			case 5:
				System.out.printf("%s\n", "�ӻ�� ���");
				break;
			case 6:
				System.out.printf("%s\n", "�ް��庴 ���");
				break;
			default:
				break;
			}
		
	
			System.out.printf("\n����� �Ѿ��� %d�� �Դϴ�.", orderItem.sum);
			System.out.printf("\n=====================================================================================\n");
			System.out.printf("\n��� �����Ͻðڽ��ϱ�? (1:���ο� �ֹ�, 2:���α׷� ����) : ");

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
