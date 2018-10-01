package it.polimi.util;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import it.polimi.domain.abstractmodel.Entry;
import it.polimi.domain.key.PartitionKey;
import it.polimi.domain.key.SortKey;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.datamodel.DataModel.Entity;

@Component
public class DataModelTransformation {

	/*
	 * name of sort key is related to the entity specified in view component
	 * @param sortKey : sort key to update
	 * @param entity : reference of sort key belongs to; used to access directly entity in data model
	 * @param dataModel
	 * 
	 * @return name of sort key specified in data model
	 */
	public String retrieveSortKeyName(SortKey sortKey, String entity, DataModel dataModel) {

		for (Entity e : dataModel.getEntity()) {
			if (e.getId().equals(entity)) {

				return e.getAttribute().stream().filter(sk -> sk.getId().equals(sortKey.getReferenceAttributeEntity()))
						.collect(Collectors.toList()).get(0).getName();
			}
		}

		return "no name found";
	}

	/*
	 * @param entityId : entity id looking for
	 * @param dataModel
	 * 
	 * @return entity by id
	 */
	public Entity retrieveEntityById(String entityId, DataModel dataModel) {

		for (Entity e : dataModel.getEntity()) {
			if (e.getId().equals(entityId)) {

				return e;
			}
		}

		return null;
	}
	
	/*
	 * name of partition key is related to another entity Iteration over all
	 * entities attributes of data model
	 * @param partitionKey : partition key to update
	 * @param dataModel
	 * @return name of partition key specified in data model
	 */
	public String retrievePartitionKeyName(PartitionKey partitionKey, DataModel dataModel) {

		for (Entity e : dataModel.getEntity()) {

			List<it.polimi.mapper.datamodel.DataModel.Entity.Attribute> attributes = e.getAttribute().stream()
					.filter(pk -> pk.getId().equals(partitionKey.getReferenceAttributeEntity()))
					.collect(Collectors.toList());

			if (!attributes.isEmpty())
				return e.getName().toLowerCase() + "_" + attributes.get(0).getName();

		}
		return "no name found";
	}

	/**
	 * @param entry: entry to update
	 * @param entity: used to access directly entity in data model
	 * @param dataModel
	 * @return name of entry specified in view component
	 */
	public String retrieveEntryName(Entry entry, String entity, DataModel dataModel) {

		for (Entity e : dataModel.getEntity()) {
			if (e.getId().equals(entity)) {

				return e.getAttribute().stream().filter(en -> en.getId().equals(entry.getId()))
						.collect(Collectors.toList()).get(0).getName();
			}
		}

		return null;
	}

	/**
	 * @param entry: entry to update
	 * @param entity: used to access directly entity in data model
	 * @param dataModel
	 * @return type of entry specified in view component
	 */
	public String retrieveEntryType(Entry entry, String entity, DataModel dataModel) {

		for (Entity e : dataModel.getEntity()) {
			if (e.getId().equals(entity)) {

				return e.getAttribute().stream().filter(en -> en.getId().equals(entry.getId()))
						.collect(Collectors.toList()).get(0).getType();
			}
		}

		return null;
	}

}
