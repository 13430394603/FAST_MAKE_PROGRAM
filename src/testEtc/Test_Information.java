package testEtc;

import java.util.Scanner;

public class Test_Information {
	
	public static void main(String[] args) {
		System.out.println("欢迎使用求租客户管理系统：");
		
				
		//房源管理
		String[] hoseResource_mess = {"","","",""};
		DoRun[] hoseResource_runs = {};
		TestShow hoseResource = new TestShow(hoseResource_mess, hoseResource_runs);
		
		//出租人员管理
		
		String[] leaseer_mess = {"","","",""};
		DoRun[] leaseer_runs = {};
		TestShow leaseer = new TestShow(leaseer_mess, leaseer_runs);
		
		//求租者管理
		String[] rentinger_mess = {"添加求租客户信息", "查询所有求租客户信息", 
				"修改求租客户信息", "删除求租客户信息", "返回上一级"};
		DoRun[] rentinger_runs = {
			() -> System.out.println(0), 
			() -> System.out.println(1), 
			() -> System.out.println(2),
			() -> System.out.println(3),
			() -> {System.out.println("返回根目录...");}
		};
		TestShow rentinger = new TestShow(rentinger_mess, rentinger_runs);
		
		//主菜单
		String[] menu_mess = {"房源管理","出租人员管理","求租者管理", "退出"};
		DoRun[] menu_runs = {
				() -> hoseResource.showCommand(), 
				() -> leaseer.showCommand(), 
				() -> rentinger.showCommand(),
				() -> {System.out.println("退出成功！");System.exit(0);}
		};	
		TestShow menu = new TestShow(menu_mess, menu_runs);
		menu.showMenuCommand();
	}
}
class TestShow{
	private Scanner scanner = new Scanner(System.in);
	private String[] mess;
	private DoRun[] runs;
	public TestShow(String[] mess, DoRun[] runs){
		this.mess = mess;
		this.runs = runs;
	}
	public void showCommand(){
		int len = mess.length;
		for(int i = 0; i < len; i++)
			showStyle(i, mess);
		while(true)
			inputCommand(runs);
	}
	//针对主菜单--只输入一次当前层次命令
	public void showMenuCommand(){
		int len = mess.length;
		for(int i = 0; i < len; i++)
			showStyle(i, mess);
		inputCommand(runs);
	}
	//显示命令样式
	protected void showStyle(int i, String[] mess){
		System.out.println("【"+i+"】"+mess[i]);
	}
	
	public void inputCommand(DoRun[] runs){
		System.out.println("Pleace input command：");
		int One = scanner.nextInt();
		if(One >=0 && One < runs.length)
			runs[One].execute();
		else {
			System.out.println("对不起，您的输入有误，请重新输入！！！");
			inputCommand(runs);
		}
	}
}
interface DoRun{
	void execute();
}
