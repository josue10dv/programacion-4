import { useCallback, useEffect, useState } from "react";
import { UserApi } from "../types/ApiUsers";
import { createUser, getUser, updateUser } from "../services/Users.repo";

export function useUserForm(id?: number) {
    const [values, setValues] = useState<UserApi>({ name: "", username: "", email: "" });
    const [loading, setLoading] = useState(false);
    const [saving, setSaving] = useState(false);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        if (!id) return;
        setLoading(true);
        setError(null);
        getUser(id)
            .then((data) => setValues({ name: data.name, username: data.username, email: data.email, id }))
            .catch((e) => setError(e.message ?? "Error cargando usuario"))
            .finally(() => setLoading(false));
    }, [id]);

    const onChange = useCallback((key: keyof UserApi, value: string) => {
        setValues((prev) => ({ ...prev, [key]: value }));
    }, []);

    const submit = useCallback(async () => {
        setSaving(true);
        setError(null);
        try {
            if (id) {
                await updateUser(id, values);
            } else {
                await createUser(values);
            }
        } catch (e: any) {
            setError(e.message ?? "Error guardando usuario");
            throw e;
        } finally {
            setSaving(false);
        }
    }, [id, values]);

    return { values, onChange, loading, saving, error, submit };
}