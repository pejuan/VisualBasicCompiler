.data
_a: .word 10
_b: .word 20
_c: .word 30
_msg1: .asciiz "Hola"
_msg2: .asciiz "If anidado"

.text
.globl main

main:
	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 4
	la $a0,_msg2
	syscall


	li $v0,10
	syscall
