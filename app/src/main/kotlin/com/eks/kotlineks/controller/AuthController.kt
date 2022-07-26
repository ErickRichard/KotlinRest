package com.eks.kotlineks.controller

import com.eks.kotlineks.data.vo.v1.request.AccountCredentialsVO
import com.eks.kotlineks.services.AuthService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Autorização Token")
@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    lateinit var authService: AuthService

    @Operation(summary = "Autentica um usuário e retorna um token de acesso")
    @PostMapping(value = ["/signin"])
    fun signin(@RequestBody data: AccountCredentialsVO?): ResponseEntity<*> {
        return if (data!!.username.isNullOrBlank() || data.password.isNullOrBlank()) ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        else authService.signin(data)
    }

    @Operation(summary = "Atualiza token para usuário autenticado e retornar um novo token")
    @PutMapping(value = ["/refresh/{username}"])
    fun refreshToken(@PathVariable("username") username: String?, @RequestHeader("Authorization") refreshToken: String?): ResponseEntity<*> {
        return if (refreshToken.isNullOrBlank() || username.isNullOrBlank())
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        else authService.refreshToken(username, refreshToken)
    }
}