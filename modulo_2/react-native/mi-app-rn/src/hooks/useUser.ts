import { useCallback, useEffect, useState } from "react";
import { UserApi } from "../types/ApiUsers";
import { deleteUser, getUsers } from "../services/Users.repo";

export function useUsers() {
    const [users, setUsers] = useState<UserApi[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    const load = useCallback(async () => {
        try {
            setLoading(true);
            setError(null);
            const data = await getUsers();
            setUsers(data);
        } catch (e: any) {
            setError(e.message ?? "Error cargando usuarios");
        } finally {
            setLoading(false);
        }
    }, []);

    useEffect(() => { load(); }, [load]);

    const remove = useCallback(async (id: number) => {
        try {
            await deleteUser(id);
            // Optimista: filtra local sin re-fetch (en producción, revalidar)
            setUsers((prev) => prev.filter((u) => u.id !== id));
        } catch (e: any) {
            setError(e.message ?? "Error eliminando usuario");
            throw e;
        }
    }, []);

    return { users, loading, error, reload: load, remove };
}