# WRM - Waiting Room Management 🏥🚶‍♂️

## Description 📝
The **WRM (Waiting Room Management)** module is an API for managing waiting rooms. It allows organizations such as medical offices, public services, or businesses to efficiently manage their visitors' queues. This centralized system organizes visitor flows based on various scheduling algorithms and provides performance statistics to improve visitor management. 📊⏳

### Context
Organizations need solutions to manage visitor flows in waiting rooms, organize their reception in an orderly manner, and collect statistical data on their management. The WRM module addresses this need with dynamic visitor management, customizable scheduling and waiting room capacity, and performance statistics on visitors.

## Main Features 🚀
- **Dynamic visitor management**: Tracks the status of each visitor in the waiting room (Waiting, In Progress, Finished, Canceled).
- **Scheduling configuration**: Configures several visitor scheduling algorithms:
  - FIFO (First In, First Out) ⏰
  - Priority (based on criteria like visitor type or urgency) ⚡
  - SJF (Shortest Job First - priority service for short tasks) 🏃‍♂️
- **Customizable schedules and capacities**: Defines maximum capacities and service hours for each day of the week. 🗓️
- **Statistics and performance**: Generates performance indicators, such as average waiting times. 📈

## Managed Entities 📋
### 1. Visitor
- **id** : `Long`, unique identifier.
- **name** : `String`, visitor's name.
- **arrivalTime** : `DateTime`, time of arrival.
- **status** : `Enum`, visitor's status (`WAITING`, `IN_PROGRESS`, `FINISHED`, `CANCELLED`).
- **priority** : `Integer`, priority level (for the HPF algorithm).
- **estimatedProcessingTime** : `Integer`, estimated duration in minutes (for the SJF algorithm).
- **startTime** : Service start time.
- **endTime** : Service end time.

### 2. WaitingRoom
- **id** : `Long`, unique identifier.
- **date** : `Date`, date of the waiting room.

## Prerequisites ⚙️
Before starting, make sure you have the following installed:

- **JDK 17** or a higher version.
- **Docker** (to run PostgreSQL in a container).
- **Maven** for managing project dependencies.

# 🏥 WRM API Documentation

This document provides the API endpoints for managing waiting rooms, visitors, and their visits in the WRM (Waiting Room Management) system.

## 📚 API Endpoints

### **Visit**
- **POST** `/api/v1/visit/save`  
  Subscribe a new visitor to a waiting room.
  
- **PUT** `/api/v1/visit/visitors/{visitorId}/waiting-rooms/{waitingRoomId}/cancelVisit`  
  Cancel the visit for a specific visitor in a waiting room.

- **PUT** `/api/v1/visit/visitors/{visitorId}/waiting-rooms/{waitingRoomId}/beginVisit`  
  Begin a visit for a specific visitor in a waiting room.

- **PUT** `/api/v1/visit/visitors/{visitorId}/waiting-rooms/{waitingRoomId}/completeVisit`  
  Complete a visit for a specific visitor in a waiting room.

- **GET** `/api/v1/visit/visitors/waiting-rooms/List`  
  Get a list of all visits in waiting rooms.

- **GET** `/api/v1/visit/findById/visitors/{visitorId}/waiting-rooms/{waitingRoomId}`  
  Find a specific visit by visitor and waiting room IDs.

- **GET** `/api/v1/visit/average-waiting-time`  
  Calculate and return the average waiting time for visits.

---

### **Visitor**
- **GET** `/api/v1/visitor/{id}`  
  Get details of a specific visitor by ID.

- **GET** `/api/v1/visitor`  
  Get a list of all visitors.

- **POST** `/api/v1/visitor/save`  
  Save a new visitor.

---

### **Waiting Room**
- **POST** `/api/v1/Waiting-List/save`  
  Create a new waiting room.

- **GET** `/api/v1/Waiting-List/{id}/find`  
  Find a waiting room by ID.

- **PUT** `/api/v1/Waiting-List/{id}/edit`  
  Update an existing waiting room by ID.

- **GET** `/api/v1/Waiting-List/findAll`  
  Get a list of all waiting rooms.

- **DELETE** `/api/v1/Waiting-List/{id}/remove`  
  Remove a waiting room by ID.

---

## 🧰 Technologies & Tools Used 🛠️
- Spring Boot
- Spring Data JPA
- PostgreSQL (with Docker)
- MapStruct
- Postman (for testing APIs)
- @RestControllerAdvice
- Spring Profiles (dev, sit, uat)
- Docker for PostgreSQL container

## 🚀 Setup Instructions
1. Clone the repository.
2. Set up the PostgreSQL database in a Docker container.
3. Configure application properties for different environments (dev, prod).
4. Use Postman to test the endpoints.

---

## 💡 Additional Features
- Dynamic scheduling of visitor management with multiple algorithms.
- Performance metrics such as average wait time.
- Customizable waiting room capacities and working hours.
