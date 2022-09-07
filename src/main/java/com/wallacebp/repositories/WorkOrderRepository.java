package com.wallacebp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallacebp.entities.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long>{

}
