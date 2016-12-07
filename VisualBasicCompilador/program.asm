.data
_Unitec: .word 0
_msg1: .asciiz "Hola Mundo "
_msg2: .asciiz "Ingrese el valor para Unitec "

.text
.globl main

main:
	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 4
	la $a0,_msg2
	syscall

	li $v0, 5
	syscall
	sw $v0,_Unitec

	li $v0, 1
	lw $a0,_Unitec
	syscall


	li $v0,10
	syscall
