# Patterns
Репозиторий с кодом, написанным для предмета "Шаблоны проектирования ПО"

Включает в себя:
* Интерфейсы IPoint, ICurve, IDrawable, IDrawer.
* Абстрактный класс ACurve, классы Line для прямых линий и Bezier для кривых Безье.
* Различные рисовальщики:
  * JFXDrawerBlack - рисует линии черным цветом, пунктиром, на начальной и конечной точках рисуются черные квадраты
  * JFXDrawerGreen - рисует линии зеленым, на конце линии рисует стрелку, в начале - круг.
  * ConsoleDrawer - рисует линию в консоли
  * SVGDrawerGreen, SVGDrawerBlack - рисует линии, как соответствующий JFX рисовальщик, но результат выводится файлом в формате SVG
* Декораторы:
  * Fragment обрезает линию
  * MoveTo перемещает линию
  * Reverse меняет местами начальную и конечную точки
* Композиты
  * Chain и MultiChain - две реализации композита, который склеивает линии в одну.

При работе над проектом ставилась задача попрактиковаться в использовании паттернов "мост", "декоратор", "композит".
Содержание main менялось в процессе работы над проектом, на разных этапах нужно было показывать отдельные классы/возможности проекта.


