package lk.study.custom_class;

/**
 * �Զ������ݹ����� ����mName��mAddress���Ժ����getter��setter���� ����UiLayoutActivity�е�
 * setSpinner2() ����
 * 
 * @author Mr.li
 * 
 */
public class SpinnerDataClass {

	String mName;
	String mAddress;

	public SpinnerDataClass(String name, String address) {
		mName = name;
		mAddress = address;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

}
