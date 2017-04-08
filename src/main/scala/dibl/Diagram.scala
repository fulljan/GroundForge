/*
 Copyright 2015 Jo Pol
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program. If not, see http://www.gnu.org/licenses/gpl.html dibl
*/
package dibl

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport
case class Diagram(nodes: Seq[NodeProps],
                   links: Seq[LinkProps]
                  ) {

  @JSExport
  def node(i: Int): NodeProps = nodes(i)

  @JSExport
  def link(i: Int): LinkProps = links(i)

  //noinspection AccessorLikeMethodIsEmptyParen
  @JSExport
  def jsNodes(): js.Array[js.Dictionary[Any]] = toJS(nodes)

  //noinspection AccessorLikeMethodIsEmptyParen
  @JSExport
  def jsLinks(): js.Array[js.Dictionary[Any]] = toJS(links)

  private def toJS(items: Seq[Props]): js.Array[js.Dictionary[Any]] = {

    val jsItems = new js.Array[js.Any](items.length).asInstanceOf[js.Array[js.Dictionary[Any]]]
    for {i <- items.indices} {
      jsItems(i) = items(i).toJS()
      jsItems(i)("index") = i
    }
    jsItems
  }
}