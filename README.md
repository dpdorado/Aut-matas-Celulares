# Autómatas celulares - Juego de la vida

Se hace una simulación de autómatas celulares con java.

#
Los autómatas celulares elementales son quizás el tipo más simple de autómatacelular. Para mayor detalle sobre estos ver: http://mathworld.wolfram.com/ElementaryCellularAutomaton.html. 

* El primer requerimiento que usted debe satisfacer consiste en diseñar e implementar una aplicación software que permita simular cualquiera de los 256 autómatas celulares elementales,por una cantidad de pasos que el usuario específica a través de la interfazde la aplicación. Los resultados de la simulación pueden presentarse en pantalla, pero deben guardarse en un archivo de texto.

* El segundo requerimiento será implementar,usando el mismo software del requerimiento anterior,el Juego de la Vida al igual queel siguiente autómata celular en 2 dimensiones:
  - Estados: {Vivo, Muerto}
  - Vecindad: von Newmann, radio 1
  - Regla:
    * Si hay 2 o 3 celdas en estado vivo, el siguiente estado será vivo. 
    * El estado será muerto en cualquier otro caso.
  - Lattice:2D, tamaño definido por el usuario.
  - Frontera: Cíclica.
  - Condición inicial: aleatoria con proporción de celdas en estado vivo definido por el usuario.
