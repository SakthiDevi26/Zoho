package databaseoperations.interfaces.gettable;

import java.util.ArrayList;

public interface IdListGettable {

	public ArrayList<Integer> getAllIdList(String tableName, String valueIdColumnName);
}
