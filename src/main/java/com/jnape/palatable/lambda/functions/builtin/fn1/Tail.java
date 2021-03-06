package com.jnape.palatable.lambda.functions.builtin.fn1;

import com.jnape.palatable.lambda.functions.Fn1;

import java.util.Iterator;

/**
 * Returns the tail of an <code>Iterable</code>; the is, an <code>Iterable</code> of all the elements except for the
 * head element. If the input <code>Iterable</code> is empty, the result is also an empty <code>Iterable</code>;
 *
 * @param <A> the Iterable element type
 */
public final class Tail<A> implements Fn1<Iterable<A>, Iterable<A>> {

    private static final Tail INSTANCE = new Tail();

    private Tail() {
    }

    @Override
    public Iterable<A> apply(Iterable<A> as) {
        return () -> {
            Iterator<A> iterator = as.iterator();
            if (iterator.hasNext())
                iterator.next();
            return iterator;
        };
    }

    @SuppressWarnings("unchecked")
    public static <A> Tail<A> tail() {
        return INSTANCE;
    }

    public static <A> Iterable<A> tail(Iterable<A> as) {
        return Tail.<A>tail().apply(as);
    }
}
