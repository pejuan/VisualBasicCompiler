.data
_Unitec: .word 10
_Unitec2: .word 20
_Unitec3: .asciiz "Esto es una prueba "
_espacio: .asciiz " "
_msg1: .asciiz "Hola Mundo "
_msg2: .asciiz "Probemos Esto "
_msg3: .word 20
_msg4: .asciiz "Este es el fin "

.text
.globl main

main:
	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 4
	la $a0,_msg2
	syscall

	li $v0, 1
	lw $a0,_msg3
	syscall

	li $v0, 4
	la $a0,_espacio
	syscall

	li $v0, 1
	lw $a0,_Unitec
	syscall

	li $v0, 4
	la $a0,_espacio
	syscall

	li $v0, 1
	lw $a0,_Unitec2
	syscall

	li $v0, 4
	la $a0,_espacio
	syscall

	li $v0, 4
	la $a0,_Unitec3
	syscall

	li $v0, 4
	la $a0,_espacio
	syscall

	li $v0, 4
	la $a0,_msg4
	syscall


	li $v0,10
	syscall
