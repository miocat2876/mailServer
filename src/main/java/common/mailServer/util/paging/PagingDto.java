package common.mailServer.util.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class PagingDto {

	private final int defaultViewRow  = 20;
	private final int defaultViewPage = 10;
	private int currentPage;
	private int viewRow;
	private int viewPage;
	private ProjectNameType searchCondition = ProjectNameType.PROJECT_NAME;
	private String searchValue = "";
	private int totalRowCount;

	public int getCurrentPage() {
		return currentPage <= 0 ? 1 : currentPage;
	}
	public int getViewRow() {
		return viewRow <= 0 ? defaultViewRow : viewRow;
	}
	public int getViewPage() {
		return viewPage <= 0 ? defaultViewPage : viewPage;
	}
	public int getRowStart() {
		return ((getCurrentPage() - 1) * getViewRow());
	}
	public int getRowEnd() {
		return getViewRow();
	}
	public int getPageStart() {
		return getCurrentPage();
	}
	public int getPageEnd() {
		if(isLastPage()){
			return getTotalRowCount() / getViewRow();
		}
		return ((getCurrentPage() / getViewPage()) + 1) * getViewPage();
	}
	public boolean isLastPage(){
		return (getCurrentPage() * getViewRow()) >= getTotalRowCount();
	}
}
