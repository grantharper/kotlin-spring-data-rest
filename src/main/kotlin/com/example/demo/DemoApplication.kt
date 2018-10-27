package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@Entity
data class Person(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
                  var firstName: String, var lastName: String)

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
interface PersonRepository : PagingAndSortingRepository<Person, Long> {

    fun findByLastName(@Param("name") name: String): List<Person>
}