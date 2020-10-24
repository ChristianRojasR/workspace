##Objetivo
Se tiene como objetivo dar soluci�n a un problema utilizando el patr�n de dise�o Composite.

#Problema

Se desea construir un pelot�n de unidades militares de las cuales cada unidad puede moverse utilizando un punto de coordenadas X e Y, realizar un ataque a un objetivo determinado que ser� una unidad militar y recibir un ataque. 

#�Para qu� se utiliza el patr�n de dise�o Composite?

El patr�n de dise�o Composite nos sirve para construir estructuras complejas partiendo de otras estructuras mucho m�s simples, dicho de otra manera, podemos crear estructuras compuestas las cuales est�n conformadas por otras estructuras m�s peque�as.

#�Qu� componentes son necesarios en el Composite?

El patr�n Composite requiere m�nimo de tres componentes para poder existir los cuales son Componente, Leaf o Rama y Composite.
Component: Generalmente es una interface o clase abstracta la cual tiene las operaciones m�nimas que ser�n utilizadas, este componente deber� ser extendido o implementado por los otros dos componentes Leaf y Composite. En nuestro ejemplo esto podr�a representar de forma abstracta una Unidad o todo el Peloton.
Leaf: El leaf u hoja representa la parte m�s simple o peque�a de toda la estructura y este extiende o hereda de Component. En nuestro ejemplo, este representar�a una Unidad del pelot�n.
Composite: Aqu� es donde est� la magia de este patr�n, ya que el composite es una estructura conformada por otros Composite y Leaf. 
En nuestro ejemplo esto est� representado por la clase Pelot�n la cual tiene el m�todo agregar que nos permite incorporar objetos de tipo Component (UnidadMilitar), sin embargo, el Componente es una Interface o Clase abstracta  por lo que podremos agregamos objetos de tipo Composite o Leaf. 



#Diagrama de clases de la soluci�n
![Diagrama](diagrama.png)

