/*
 * Copyright 2016 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.gs.dmn.feel.analysis.syntax.ast.expression.arithmetic;

import com.gs.dmn.feel.analysis.syntax.ast.Visitor;
import com.gs.dmn.feel.analysis.syntax.ast.expression.Expression;
import com.gs.dmn.runtime.DMNContext;

import static com.gs.dmn.feel.analysis.semantics.type.NumberType.NUMBER;

public class Exponentiation extends ArithmeticExpression {
    public Exponentiation(Expression leftOperand, Expression rightOperand) {
        super("**", leftOperand, rightOperand);
    }

    @Override
    public void deriveType(DMNContext context) {
        setType(NUMBER);
        checkType(getOperator(), getLeftOperand().getType(), getRightOperand().getType());
    }

    @Override
    public Object accept(Visitor visitor, DMNContext params) {
        return visitor.visit(this, params);
    }

    @Override
    public String toString() {
        return String.format("%s(%s,%s)", getClass().getSimpleName(), getLeftOperand(), getRightOperand());
    }
}

 
