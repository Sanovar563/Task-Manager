package com.Taskmanager.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
public class Task {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String description;
	    private boolean completed;


	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private User user;

	    @Column(name = "due_date")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date dueDate;

	    @Column(name = "priority")
	    private int priority;

		
	}


