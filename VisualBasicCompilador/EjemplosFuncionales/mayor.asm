.data
_a: .word 1
_mayor: .word 0
_msg1: .asciiz "Ingrese un numero "
_msg2: .asciiz "El mayor es "

.text
.globl main

main:
_etiqueta0:

	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 5
	syscall
	sw $v0,_a

	lw $t0, _a
	lw $t1, _mayor
	bgt $t0, $t1, _etiqueta1
	b _etiqueta2

_etiqueta1:

	lw $t0,_a
	sw $t0,_mayor
_etiqueta2:

	lw $t0, _a
li $t1, 0
	bne $t0, $t1, _etiqueta0
	li $v0, 4
	la $a0,_msg2
	syscall

	li $v0, 1
	lw $a0,_mayor
	syscall


	li $v0,10
	syscall
