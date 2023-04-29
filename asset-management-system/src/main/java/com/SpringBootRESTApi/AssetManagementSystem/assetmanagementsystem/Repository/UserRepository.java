package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
