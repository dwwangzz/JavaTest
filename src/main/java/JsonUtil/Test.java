package JsonUtil;

import java.util.List;

public class Test {

	private String account;

	private List<Infos> infos;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<Infos> getInfos() {
		return infos;
	}

	public void setInfos(List<Infos> infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "Test [account=" + account + ", infos=" + infos.toString() + "]";
	}

}
