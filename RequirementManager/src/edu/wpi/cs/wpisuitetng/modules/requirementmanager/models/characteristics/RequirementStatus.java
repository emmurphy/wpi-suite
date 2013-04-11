
package edu.wpi.cs.wpisuitetng.modules.requirementmanager.models.characteristics;

/**
 * Various status' that a Requirement can have 
 * @author david
 */
public enum RequirementStatus {
	/**
	 * Indicates that the Requirement has only been created
	 */
	NEW("New"),
	/**
	 * Indicates that the Requirement has been assigned to an iteration
	 */
	INPROGRESS("In Progress"),
	/**
	 * Indicates that the Requirement has been removed from an iteration and returned to the backlog
	 */
	OPEN("Open"),
	/**
	 * Indicates that the Requirement has been accepted by the customer
	 */
	COMPLETE("Complete"),
	/**
	 * Indicates that the Requirement has been deleted
	 */
	DELETED("Deleted");
	
	private final String name;
	
	private RequirementStatus(String stat)
	{
		name = stat;
	}
	
	public String toString()
	{
		return name;
	}
}
