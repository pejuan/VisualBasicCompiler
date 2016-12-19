.data
_a: .word 0
_b: .word 1
_msg1: .asciiz "Ingrese el numero para calcular factorial "
_msg2: .asciiz "El factorial es "

.text
.globl main

main:
	li $v0, 4
	la $a0,_msg1
	syscall

	li $v0, 5
	syscall
	sw $v0,_a

_etiqueta0:

	lw $t0, _b
	lw $t1,_a
	mul $t2, $t0, $t1
	sw $t2,_b
	lw $t0, _a
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2,_a
	lw $t0, _a
li $t1, 1
	bne $t0, $t1, _etiqueta0
	li $v0, 4
	la $a0,_msg2
	syscall

	li $v0, 1
	lw $a0,_b
	syscall


	li $v0,10
	syscall
