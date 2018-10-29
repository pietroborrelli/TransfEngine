package it.polimi.parser;

import java.util.List;

import it.polimi.domain.abstractmodel.Block;
import it.polimi.domain.abstractmodel.Collection;
import it.polimi.domain.abstractmodel.Entry;
import it.polimi.domain.key.PartitionKey;
import it.polimi.domain.key.SortKey;

public interface Parser {

	public String getNameColumnFamily(Collection collection);
	public String getPrimaryKey(Block block);
	public String getColumns(List<Entry> entries);
	public String buildPhysicalModel(Collection collection);
	public String getSortKeys(Block block);
	public String getPartitionKeys(List<PartitionKey> partitionKeys);
	public String getSortKeys(List<SortKey> sortKeys);
}
