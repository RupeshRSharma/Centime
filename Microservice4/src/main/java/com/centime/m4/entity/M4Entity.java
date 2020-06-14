/**
 * 
 */
package com.centime.m4.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JPA entity for Micro service 4
 * 
 * @author Rupesh Sharma
 *
 */

@Entity
@Table(name = "M4ENTITY")
public class M4Entity implements Serializable {

	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = 7253296184923269673L;


	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Primary key ID

	@Column(name = "PARENT_ID")
	private Long parentId; // Parent id

	@Column(name = "NAME")
	private String name; // Name
	
	@Column(name = "COLOR")
	private String color; // Color

	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PARENT_ID", insertable=false, updatable=false)
	private M4Entity parent; // Parent entity

	@JsonIgnore
	@OneToMany(mappedBy = "parent")
	private Set<M4Entity> children = new HashSet<M4Entity>(); // Children

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the parent
	 */
	public M4Entity getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(M4Entity parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public Set<M4Entity> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<M4Entity> children) {
		this.children = children;
	}

}
