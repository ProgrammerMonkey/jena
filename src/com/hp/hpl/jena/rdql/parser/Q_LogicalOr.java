/*
 * (c) Copyright 2001-2003, Hewlett-Packard Company, all rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.rdql.parser;

import com.hp.hpl.jena.rdql.* ;
import java.io.PrintWriter;

/* This file is automatically generated - do not edit.
 * Arguments: 
 *       Name = LogicalOr
 *       Operator = ||
 *       Print Name = or
 *       Template = ExprBooleanBLANK2.java
 */

/** 
 * @author Automatically generated class: Operator: LogicalOr
 * @version $Id: Q_LogicalOr.java,v 1.4 2003-06-19 08:42:44 andy_seaborne Exp $
 */

public class Q_LogicalOr extends SimpleNode implements Expr, ExprBoolean
{
    Expr left ;
    Expr right ;

    private String printName = "or" ;
    private String opSymbol = "||" ;

    Q_LogicalOr(int id) { super(id); }

    Q_LogicalOr(RDQLParser p, int id) { super(p, id); }

    public Value eval(Query q, ResultBinding env)
    {
        Value x = left.eval(q, env) ;
        Value y = right.eval(q, env) ;
        
        if ( ! x.isBoolean() )
            throw new EvalTypeException("Q_LogicalOr: Wanted a boolean: "+x) ;
        if ( ! y.isBoolean() )
            throw new EvalTypeException("Q_LogicalOr: Wanted a boolean: "+y) ;

        Settable result ;
        if ( x instanceof Settable )
            result = (Settable)x ;
        else if ( y instanceof Settable )
            result = (Settable)y ;
        else
            result = new WorkingVar() ;

        boolean b = (x.getBoolean() || y.getBoolean()) ;
        result.setBoolean(b) ;
        return result ;
    }

    public void jjtClose()
    {
        int n = jjtGetNumChildren() ;
        if ( n != 2 )
            throw new QueryException("Q_LogicalOr: Wrong number of children: "+n) ;
        
        left = (Expr)jjtGetChild(0) ;
        right = (Expr)jjtGetChild(1) ;
    }

    public String asInfixString()
    {
        return QueryPrintUtils.asInfixString2(left, right, printName, opSymbol) ;
    }

    public String asPrefixString()
    {
        return QueryPrintUtils.asPrefixString(left, right, printName, opSymbol) ;
    }

    public void print(PrintWriter pw, int level)
    {
        QueryPrintUtils.print(pw, left, right, printName, opSymbol, level) ;
    }

    public String toString()
    {
        return asInfixString() ;
    }
}

/*
 *  (c) Copyright Hewlett-Packard Company 2001-2003, 2001-2003
 *  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
