package lk.study.custom_class;

/**
 * 自定义数据管理类 包含mName和mAddress属性和相关getter，setter方法 用在UiLayoutActivity中的
 * setSpinner2() 方法
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
