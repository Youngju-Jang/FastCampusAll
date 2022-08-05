package p2_ch5;

public class Member implements Comparable<Member>{
	
	private int memberId;
	private String memberName;
	
	public Member() {}
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}

	@Override
	public int compareTo(Member member) {
		// TODO Auto-generated method stub
		//return (this.memberId - member.memberId);   //오름차순
		return (this.memberId - member.memberId) *  (-1);   //내림 차순

	}
	
	
}
