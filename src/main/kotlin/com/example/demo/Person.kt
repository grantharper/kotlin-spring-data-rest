package com.example.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
                  var firstName: String, var lastName: String)