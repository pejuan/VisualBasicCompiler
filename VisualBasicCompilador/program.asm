.data
_Unitec: .word 96
_msg1: .asciiz "Hola Mundo "
_msg2: .word 20
_msg3: .asciiz Unitec

.text
.globl main

main:
	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 1
	lw $a0,_msg2
	syscall

_msg3
	syscall


	li $v0,10
	syscall
