package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import DBVO.BoardVO;

public class BoardDB {
	Scanner sc= new Scanner(System.in);
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String uid = "green01";
	private final String upw = "1234";
	
	public Connection dbConnet() throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection cnn = DriverManager.getConnection(url,uid,upw);		
		return cnn;		
	}
	
	public void page(int n) throws Exception {
		String query = "select * from v_b where n between ? and ?";
		PreparedStatement pstmt = dbConnet().prepareStatement(query);
	    int Last = 5*n;
	    int First = Last-4;
	    pstmt.setInt(1, First);
	    pstmt.setInt(2, Last);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			BoardVO vo  = new BoardVO();
			
			vo.setBoardNum(rs.getInt("num"));
			vo.setTitle(rs.getString("title"));
			vo.setBoardwriter(rs.getString("writer"));
			vo.setDate(rs.getString("regdate"));
			
			Statement stmt = dbConnet().createStatement();
			String query2 = "select count(*) from reply where board_num="+vo.getBoardNum();
			ResultSet rs2 = stmt.executeQuery(query2);
			while(rs2.next()) {
				vo.setReplyCount(rs2.getInt(1));
				System.out.println(vo.toString());
			}
			
			
		}
	}

	public void update() throws Exception {
		
		
		System.out.println("1.���� 2.���� 3.�Ѵ�");
		String sel = sc.nextLine();
		
		if(sel.equals("3")) { 
			String query = "update board set title=?,contentes=? where num=?";
			PreparedStatement pstmt = dbConnet().prepareStatement(query);
			System.out.println("������ �Խù� ��ȣ�� �Է��ϼ���");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("�� ���� �Է�>>");
			String title = sc.nextLine();
            System.out.print("�� ������ �Է�>>");
            String con = sc.nextLine();
            
            pstmt.setString(1, title);
            pstmt.setString(2, con);
            pstmt.setInt(3, num);
            
            int rs = pstmt.executeUpdate();
            if(rs==1) {
            	System.out.println(num+"�� �Խù��� �����Ǿ����ϴ�");
            }
            
		}else if(sel.equals("2")) {
			String query = "update board set contentes=? where num=?";
			PreparedStatement pstmt = dbConnet().prepareStatement(query);
			
			System.out.println("������ �Խù� ��ȣ�� �Է��ϼ���");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("�� ������ �Է�>>");
	        String con = sc.nextLine();
	        
	        
            pstmt.setString(1, con);
            pstmt.setInt(2, num);
            
            int rs = pstmt.executeUpdate();
            if(rs==1) {
            	System.out.println(num+"�� �Խù��� �����Ǿ����ϴ�");
            }
			
		}else if(sel.equals("1")) {
			String query = "update board set title=? where num=?";
			PreparedStatement pstmt = dbConnet().prepareStatement(query);
			
			System.out.println("������ �Խù� ��ȣ�� �Է��ϼ���");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("�� ���� �Է�>>");
			String title = sc.nextLine();
	        
	        
            pstmt.setString(1, title);
            pstmt.setInt(2, num);
            
            int rs = pstmt.executeUpdate();
            if(rs==1) {
            	System.out.println(num+"�� �Խù��� �����Ǿ����ϴ�");
            }
		}
	
	}

	public void insert() throws Exception {
		String query = "insert into board values((select max(num)+1 from board),?,?,?,sysdate)";
		PreparedStatement pstmt=dbConnet().prepareCall(query);
		
		System.out.print("���� �Է�>>");
		String title = sc.nextLine();
        System.out.print("���� �Է�>>");
        String con = sc.nextLine();
        System.out.print("�ۼ��� �Է�>>");
        String writer = sc.nextLine();
        
        pstmt.setString(1, title);
        pstmt.setString(2, con);
        pstmt.setString(3, writer);
        
        int rs=pstmt.executeUpdate();
	    
        if(rs==1) {
        	System.out.println("�Խù��� ��ϵǾ����ϴ�");
        }
	}

	public void delete() throws Exception {
		
		String query = "delete from board where num= ?";
		PreparedStatement pstmt=dbConnet().prepareCall(query);
		
		System.out.println("������ �Խù� ��ȣ�� �Է��ϼ���");
		int num = sc.nextInt();
		sc.nextLine();
        
        pstmt.setInt(1, num);
       
        
        int rs=pstmt.executeUpdate();
	    
        if(rs==1) {
        	System.out.println("�Խù��� �����Ǿ����ϴ�");
        }
	}

	public void selectR(int n )throws Exception {
		
		String reply = "select * from reply where board_num="+n+" order by num";
		Statement stmt = dbConnet().createStatement();
		ResultSet rs = stmt.executeQuery(reply);
		
		while(rs.next()) {
			BoardVO vo = new BoardVO();
			
            vo.setReplyNum(rs.getInt("num"));
			vo.setRepltWriter(rs.getString("name"));
			vo.setCommentes(rs.getString("comments"));
			
			System.out.println("��"+vo.getReplyNum()+" "+vo.getCommentes()+"\n �ۼ���: "+vo.getRepltWriter());
		}
	}
	
	public void insertR(int n) throws Exception {
	String query = "insert into reply values((select count(*) from reply where board_num=?)+1,?,?,?)";
	PreparedStatement pstmt=dbConnet().prepareCall(query);
	System.out.print("��� �ۼ��̸�>>");
	String name = sc.nextLine();
	System.out.print("��� �Է�>>");
	String com = sc.nextLine();
	
	pstmt.setInt(1, n);
	pstmt.setInt(2, n);
	pstmt.setString(3,com);
	pstmt.setString(4, name);
	
	int rs = pstmt.executeUpdate();
	
	if(rs==1) {
		System.out.println("����� �ԷµǾ����ϴ�");
	}
	
	}
	
	public void updateR(int n) throws Exception {
		
		String query = "update reply set comments=? where num=? and board_num=?";
		PreparedStatement pstmt = dbConnet().prepareStatement(query);
		
		System.out.print("������ ��۹�ȣ>>");
		String sel = sc.nextLine();
		System.out.print("�� ���>>");
		String com = sc.nextLine();
		
		pstmt.setString(1, com);
		pstmt.setString(2, sel);
		pstmt.setInt(3, n);
		
		int rs = pstmt.executeUpdate();
		
		if(rs==1) {
			System.out.println("����� �����Ǿ����ϴ�");
		}
		
		
	}
	
	public void deleteR(int n) throws Exception {
		
		String query = " delete from reply where num=? and board_num=?";
		PreparedStatement pstmt = dbConnet().prepareStatement(query);
		
		System.out.print("������ ��۹�ȣ>>");
		String sel = sc.nextLine();	
		
		pstmt.setString(1, sel);		
		pstmt.setInt(2, n);
		
		int rs = pstmt.executeUpdate();
		
		if(rs==1) {
			System.out.println("����� �����Ǿ����ϴ�");
		}
		
	}
	
	public void find() throws Exception {
		System.out.print("��ȸ�� �Խù� ��ȣ>>");
		int num = sc.nextInt();
		sc.nextLine();
		
		// �Խù� ���� ���̰� ��(��� ����)
		String all = "select * from board where num="+num;
		Statement stmt=dbConnet().createStatement();
		ResultSet rs = stmt.executeQuery(all);
		
		while(rs.next()) {
			BoardVO vo = new BoardVO();
			
			vo.setTitle(rs.getString("title"));
			vo.setContents(rs.getString("contentes"));
			vo.setTitle(rs.getString("title"));
			vo.setBoardwriter(rs.getString("writer"));
			vo.setDate(rs.getString("regdate"));
						
			
			System.out.println(vo.getTitle()+"\t"+vo.getBoardwriter()+"\n\n"+vo.getContents()+"\n"+vo.getDate());
			
			//��� 
			selectR(num);
			
			System.out.print("1.��� ��� 2. ��� ���� 3.��� ���� 4.��� ��ȸ  0.���â ������");
			String sel = sc.nextLine();
			
			if(sel.equals("1")) {
				insertR(num);
			}else if(sel.equals("2")) {
				updateR(num);
			}else if(sel.equals("3")) {
				deleteR(num);
			}else if(sel.equals("4")) {
				selectR(num);
			
				
			}else if(sel.equals("0")) {	
				
				System.out.println("���â ������~");
				break;
			}
		}
		
		
		
		
		
	}


}
